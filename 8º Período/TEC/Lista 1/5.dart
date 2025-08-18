import 'dart:io';

void main() {
  stdout.write("Insira o preço do produto: ");
  double price = double.parse(stdin.readLineSync()!);

  print("Formas de pagamento:");
  print("1 - À vista em dinheiro (10% de desconto)");
  print("2 - À vista no cartão (5% de desconto)");
  print("3 - Em duas vezes (sem juros)");
  print("4 - Em três vezes (10% de juros)");

  stdout.write("Escolha a forma de pagamento: ");
  int option = int.parse(stdin.readLineSync()!);

  double finalPrice;

  if (option == 1) {
    finalPrice = price * 0.9;
  } else if (option == 2) {
    finalPrice = price * 0.95;
  } else if (option == 3) {
    finalPrice = price;
  } else {
    finalPrice = price * 1.1;
  }

  print("Preço final: $finalPrice");
}
