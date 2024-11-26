import cv2
from ultralytics import YOLO

# Configuração inicial
TARGET_CLASS = "person"  # Classe alvo para rastreamento
video_path = "snow2.mp4"  # Caminho do vídeo

# Inicializa o rastreador CSRT
tracker = cv2.TrackerCSRT_create()

# Carrega o modelo YOLOv8
model = YOLO("yolov8n.pt")  # Modelo pré-treinado

# Carrega o vídeo
cap = cv2.VideoCapture(video_path)
if not cap.isOpened():
    print("Erro ao abrir o vídeo!")
    exit()

# Lê o primeiro frame
ret, frame = cap.read()
if not ret:
    print("Não foi possível ler o primeiro frame do vídeo!")
    cap.release()
    exit()

# Função para detectar e retornar o bounding box do YOLO
def detect_target(frame):
    results = model(frame)
    for result in results[0].boxes.data.tolist():
        x1, y1, x2, y2, score, class_id = result
        if model.names[int(class_id)] == TARGET_CLASS and score > 0.5:
            return int(x1), int(y1), int(x2 - x1), int(y2 - y1)  # Formato (x, y, largura, altura)
    return None

# Detecta o objeto inicial
bbox = detect_target(frame)
if bbox is None:
    print(f"Objeto da classe '{TARGET_CLASS}' não detectado no primeiro frame!")
    cap.release()
    exit()

# Inicializa o rastreador com o bounding box detectado
tracker.init(frame, bbox)

while True:
    ret, frame = cap.read()
    if not ret:
        break

    # Atualiza o rastreador
    ret, bbox = tracker.update(frame)
    if ret:
        # Desenha o bounding box
        x, y, w, h = map(int, bbox)
        cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)
    else:
        # Se o rastreamento falhar, tenta detectar novamente
        bbox = detect_target(frame)
        if bbox is not None:
            tracker = cv2.TrackerCSRT_create()  # Recria o rastreador
            tracker.init(frame, bbox)
            x, y, w, h = map(int, bbox)
            cv2.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 2)  # Bounding box azul para nova detecção
        else:
            cv2.putText(frame, "Rastreamento falhou!", (20, 80),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.75, (0, 0, 255), 2)

    # Mostra o vídeo com o rastreamento
    cv2.imshow("CSRT Tracker", frame)

    # Sai com a tecla 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
