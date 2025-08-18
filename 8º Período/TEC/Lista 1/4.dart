import 'dart:io';

void main() {
  final salgados = {
    101: 4.5,
    102: 5.5,
    103: 6.0,
  };

  final bebidas = {
    201: 3.0,
    202: 4.5,
    203: 5.5,
  };

  stdout.write("Digite quantidade de salgados: ");
  int qntSalgados = int.parse(stdin.readLineSync()!);

  print("-----------");
  print("[101] - Coxinha - R\$ 4,50");
  print("[102] - Joelho - R\$ 5,50");
  print("[103] - Pizza - R\$ 6,00");
  stdout.write("\nDigite o código do salgado desejado: ");
  int codSalgado = int.parse(stdin.readLineSync()!);

  stdout.write("\nDigite quantidade de bebidas: ");
  int qntBebidas = int.parse(stdin.readLineSync()!);

  print("-----------");
  print("[201] - Água - R\$ 3,00");
  print("[202] - Refrigerante - R\$ 4,50");
  print("[203] - Suco - R\$ 5,50");
  stdout.write("\nDigite o código da bebida desejada: ");
  int codBebida = int.parse(stdin.readLineSync()!);

  double total = 0;

  if (qntSalgados > 0 && salgados.containsKey(codSalgado)) {
    total += salgados[codSalgado]! * qntSalgados;
  }

  if (qntBebidas > 0 && bebidas.containsKey(codBebida)) {
    total += bebidas[codBebida]! * qntBebidas;
  }

  print("-----------");
  print("\nValor total da compra: R\$ ${total.toStringAsFixed(2)}");
}
