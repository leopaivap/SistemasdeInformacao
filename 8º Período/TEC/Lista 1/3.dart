import 'dart:io';

void main() {
  stdout.write("Insira o salário do funcionário: ");
  double salary = double.parse(stdin.readLineSync()!);

  double newSalary = salary * 1.15;
  print("Salário com aumento: $newSalary");
}
