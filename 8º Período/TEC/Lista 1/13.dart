import 'dart:io';

double percentageIncrease(double oldValue, double newValue) {
  return ((newValue - oldValue) / oldValue) * 100;
}

void main() {
  stdout.write("Insira o valor antigo: ");
  double oldValue = double.parse(stdin.readLineSync()!);

  stdout.write("Insira o valor atual: ");
  double newValue = double.parse(stdin.readLineSync()!);

  print("Percentual de acréscimo: ${percentageIncrease(oldValue, newValue)}%");
}
