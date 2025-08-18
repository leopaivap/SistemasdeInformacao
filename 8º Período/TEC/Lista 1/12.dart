import 'dart:io';

int calculate(int x, int y, int z) {
  return (x * x) + y + z;
}

void main() {
  stdout.write("Insira x: ");
  int x = int.parse(stdin.readLineSync()!);

  stdout.write("Insira y: ");
  int y = int.parse(stdin.readLineSync()!);

  stdout.write("Insira z: ");
  int z = int.parse(stdin.readLineSync()!);

  print("Resultado: ${calculate(x, y, z)}");
}
