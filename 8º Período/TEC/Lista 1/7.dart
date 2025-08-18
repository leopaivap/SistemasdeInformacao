import 'dart:io';

void main() {
  stdout.write("Insira o salário: ");
  double salary = double.parse(stdin.readLineSync()!);

  stdout.write("Insira o cargo: ");
  String role = stdin.readLineSync()!.toLowerCase();

  double increase;

  if (role == "gerente") {
    increase = 0.3;
  } else if (role == "engenheiro") {
    increase = 0.2;
  } else if (role == "tecnico") {
    increase = 0.1;
  } else {
    increase = 0.4;
  }

  double newSalary = salary * (1 + increase);

  print("Salário antigo: $salary");
  print("Novo salário: $newSalary");
  print("Diferença: ${newSalary - salary}");
}
