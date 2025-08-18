import 'dart:io';

void main() {
  List<int> numbers = [];

  for (int i = 0; i < 5; i++) {
    stdout.write("Insira um número: ");
    numbers.add(int.parse(stdin.readLineSync()!));
  }

  print("Ordem inversa: ${numbers.reversed.toList()}");
}
