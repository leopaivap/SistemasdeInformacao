import 'dart:io';

void main() {
  stdout.write("Insira um número inteiro: ");
  int number = int.parse(stdin.readLineSync()!);

  bool isPrime = true;

  if (number <= 1) {
    isPrime = false;
  } else {
    for (int i = 2; i <= number ~/ 2; i++) {
      if (number % i == 0) {
        isPrime = false;
        break;
      }
    }
  }

  if (isPrime) {
    print("$number é primo");
  } else {
    print("$number não é primo");
  }
}
