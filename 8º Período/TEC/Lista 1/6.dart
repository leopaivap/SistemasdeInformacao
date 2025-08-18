import 'dart:io';

void main() {
  stdout.write("Ano do carro: ");
  int year = int.parse(stdin.readLineSync()!);

  stdout.write("Valor do carro: ");
  double price = double.parse(stdin.readLineSync()!);

  double tax;
  if (year < 2000) {
    tax = price * 0.01;
  } else {
    tax = price * 0.015;
  }

  print("Imposto a ser pago: $tax");
}
