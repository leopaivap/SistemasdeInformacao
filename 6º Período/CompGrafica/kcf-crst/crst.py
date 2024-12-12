import cv2
from ultralytics import YOLO


TARGET_CLASS = "person"  
video_path = "snow2.mp4"  

tracker = cv2.TrackerCSRT_create()

model = YOLO("yolov8n.pt")

cap = cv2.VideoCapture(video_path)
if not cap.isOpened():
    print("Erro ao abrir o vídeo!")
    exit()

ret, frame = cap.read()
if not ret:
    print("Não foi possível ler o primeiro frame do vídeo!")
    cap.release()
    exit()

def detect_target(frame):
    results = model(frame)
    for result in results[0].boxes.data.tolist():
        x1, y1, x2, y2, score, class_id = result
        if model.names[int(class_id)] == TARGET_CLASS and score > 0.5:
            return int(x1), int(y1), int(x2 - x1), int(y2 - y1)  
    return None

bbox = detect_target(frame)
if bbox is None:
    print(f"Objeto da classe '{TARGET_CLASS}' não detectado no primeiro frame!")
    cap.release()
    exit()

tracker.init(frame, bbox)

while True:
    ret, frame = cap.read()
    if not ret:
        break

    ret, bbox = tracker.update(frame)
    if ret:
        x, y, w, h = map(int, bbox)
        cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)
    else:
        bbox = detect_target(frame)
        if bbox is not None:
            tracker = cv2.TrackerCSRT_create()  
            tracker.init(frame, bbox)
            x, y, w, h = map(int, bbox)
            cv2.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 2)  
        else:
            cv2.putText(frame, "Rastreamento falhou!", (20, 80),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.75, (0, 0, 255), 2)

    cv2.imshow("CSRT Tracker", frame)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
