const form = document.getElementById('form');
const descInput = document.getElementById('descricao');
const valorInput = document.querySelector('#montante');
const balancoH1 = document.getElementById('balanco');
const receita = document.getElementById('din-positivo');
const despesa = document.getElementById('din-negativo');
const transacaoUL = document.getElementById('transacoes');

form.addEventListener("submit", event => {
    event.preventDefault(); // Não submete formulário

    const descTransacao = descInput.value.trim();
    const valorTransacao = valorInput.value.trim();

    if (descInput == '') {
        alert('Informe a descrição da transação');
        descInput.focus();
        return;
    }

    if (valorInput == '') {
        alert('Informe o valor da transação');
        valorInput.focus();
        return;
    }

    const transacao = {
        id: parseInt(Math.random() * 10000),
        desc: descTransacao,
        value: parseFloat(valorTransacao)
    }

    somaAoSaldo(transacao);
    somaReceitaDespesa(transacao);
    addTransacaoDOM(transacao);

    descInput.value = '';
    valorInput.value = '';
    descInput.focus();
});

function somaAoSaldo(transacao) {
    // recuperar o elemento
    // pegar o valor e remover o R$

    let valorBalanco = balancoH1.innerHTML.trim();
    valorBalanco = valorBalanco.replace("R$", "");

    valorBalanco = parseFloat(valorBalanco);
    valorBalanco += transacao.value;

    balancoH1.innerHTML = `R$${valorBalanco.toFixed(2)}`;

    //alert(typeof valorBalanco + ": " + valorBalanco);
}

function somaReceitaDespesa(transacao) {
    const elemento = transacao.value > 0 ? receita : despesa;
    const substituir = transacao.value > 0 ? "+ R$" : "- R$";

    let valor = elemento.innerHTML.replace(substituir, "");
    valor = parseFloat(valor);
    valor += Math.abs(transacao.value);

    elemento.innerHTML = `${substituir}${valor.toFixed(2)}`;
}

function addTransacaoDOM(transacao) {
    const cssClass = transacao.value > 0 ? 'positivo' : 'negativo';
    const currency = transacao.valur > 0 ? 'R$' : '-R$';
    const liElementStr = `${transacao.desc} <span>${currency}${Math.abs(transacao.value)}</span><button class="delete-btn">X</button>`;

    const liElement = document.createElement('li');
    liElement.innerHTML = liElementStr;
    liElement.classList.add(cssClass);
    transacaoUL.appendChild(liElement);
}