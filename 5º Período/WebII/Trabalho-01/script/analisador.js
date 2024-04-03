let num = document.getElementById('txt-num');
let lista = document.querySelector('select#select-num');
let resultado = document.getElementById('res');
let valores = [];


function isNumber(number) {
    return Number(number) >= 1 && Number(number) <= 100 ? true : false;
}

function inList(number, list) {
    return list.indexOf(Number(number)) != -1 ? true : false;
}

function adicionar() {
    if (isNumber(num.value) && !inList(num.value, valores)) {
        valores.push(Number(num.value));
        let item = document.createElement('option');
        item.text = `Valor ${num.value} adicionado.`;
        lista.appendChild(item);

    } else {
        window.alert('Valor inválido ou já encontrado na lista.')
    }

    num.value = '';
    num.focus();
}

function finalizar() {
    if (valores.length == 0) {
        window.alert('Adicione valores antes de finalizar.')
    } else {
        let qtd = valores.length;
        let maior = valores[0];
        let menor = valores[0];
        let soma = 0, media = 0;
        for (pos in valores) {
            soma += valores[pos];
            if (valores[pos] > maior)
                maior = valores[pos];
            if (valores[pos] < menor)
                menor = valores[pos];
        }
        media = soma / qtd;
        resultado.innerHTML = '';
        resultado.innerHTML += `Ao todo, temos ${qtd} números cadastrados.<br>`
        resultado.innerHTML += `Maior  Valor: ${maior}<br>`
        resultado.innerHTML += `Menor Valor: ${menor}<br>`
        resultado.innerHTML += `Soma Total: ${soma}<br>`
        resultado.innerHTML += `Média: ${media}<br>`
    }
}