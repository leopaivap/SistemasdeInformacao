import cv2
import matplotlib.pyplot as plt

gray_image = cv2.imread('dog_black_white.png', cv2.IMREAD_GRAYSCALE)

color_image = cv2.imread('colorfull.jpg')

# Gerar histograma para imagem em tons de cinza
plt.figure(figsize=(10, 5))
plt.subplot(1, 2, 1)
plt.hist(gray_image.ravel(), bins=256, range=[0, 256], color='black')
plt.title("Histograma - Tons de Cinza")
plt.xlabel("Níveis de Intensidade")
plt.ylabel("Número de Pixels")

colors = ('b', 'g', 'r')  # Canais: Azul, Verde, Vermelho
plt.subplot(1, 2, 2)
for i, color in enumerate(colors):
    hist = cv2.calcHist([color_image], [i], None, [256], [0, 256])
    plt.plot(hist, color=color)
plt.title("Histograma - Imagem Colorida")
plt.xlabel("Níveis de Intensidade")
plt.ylabel("Número de Pixels")

plt.tight_layout()
plt.show()
