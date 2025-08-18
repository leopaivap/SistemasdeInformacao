import 'dart:io';

void main() {
  stdout.write("Insira um número real: ");
  double number = double.parse(stdin.readLineSync()!);

  double fifthPart = number / 5;
  print("A quinta parte é: $fifthPart");
}
