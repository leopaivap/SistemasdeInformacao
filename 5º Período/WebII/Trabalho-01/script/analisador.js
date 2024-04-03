
num = document.getElementById('txt-numero');
select = document.querySelector('select#select-numeros');
resultado = document.getElementById('resultado-texto');
numeros = [];


function isNumber(n) {
    if (Number(n) >= 1 && Number(n) <= 100)
        return true;

    return false
}

function inList(n, array) {
    if (array.indexOf(Number(n)) != -1)
        return true

    return false
}

function adicionar() {

    if (isNumber(num.value) && !inList(num.value, numeros)) {
        numeros.push(Number(num.value));
        item = document.createElement('option');
        item.text = `Valor ${num.value} adicionado.`;
        select.appendChild(item);
        resultado.innerHTML = '';
    } else {
        window.alert('[ERRO] Valor inválido ou já encontrado na lista.')
    }

    num.value = '';
    num.focus();
}

function finalizar() {

    if (numeros.length == 0) {
        window.alert('Adicione valores antes de finalizar.')
    } else {
        quantidade = numeros.length;
        maior = numeros[0];
        menor = numeros[0];
        soma = 0;
        for (i in numeros) {
            soma += numeros[i];
            if (numeros[i] > maior)
                maior = numeros[i];
            if (numeros[i] < menor)
                menor = numeros[i];
        }
        media = soma / quantidade;
        resultado.innerHTML = '';
        resultado.innerHTML += `Ao todo temos ${quantidade} números cadastrados.<br>`
        resultado.innerHTML += `Maior = ${maior}<br>`
        resultado.innerHTML += `Menor = ${menor}<br>`
        resultado.innerHTML += `Soma = ${soma}<br>`
        resultado.innerHTML += `Média = ${media}<br>`
    }
}