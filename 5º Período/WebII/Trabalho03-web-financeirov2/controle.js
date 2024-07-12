const chave_transacoes_ls = "transacoes";
const chave_id_ls = "ids";

const form = document.getElementById('form');
const descInput = document.getElementById('descricao');
const valorInput = document.querySelector('#montante');
const balancoH1 = document.getElementById('balanco');
const receita = document.getElementById('din-positivo');
const despesa = document.getElementById('din-negativo');
const transacaoUL = document.getElementById('transacoes');
const tipoTransacaoComponente = document.getElementById('tipoDeTransacao');

let tipoTransacao;

let transacoesSalvas = JSON.parse(localStorage.getItem(chave_transacoes_ls));
if (transacoesSalvas == null) {
    transacoesSalvas = [];
}

let idSalvos = JSON.parse(localStorage.getItem(chave_id_ls));
if (idSalvos == null) {
    idSalvos = [];
}

document.getElementById('tipoDeTransacao').addEventListener('change', function () {
    tipoTransacao = this.value;
});

form.addEventListener("submit", event => {
    event.preventDefault();

    const descTransacao = descInput.value.trim();
    const valorTransacao = valorInput.value.trim();

    if (descTransacao === '') {
        alert('Informe a descrição da transação');
        descInput.focus();
        return;
    }

    if (valorTransacao === '') {
        alert('Informe o valor da transação');
        valorInput.focus();
        return;
    }

    if (tipoTransacao == null) {
        alert('Selecione o tipo da transação');
        return;
    }

    const transacao = {
        id: idSalvos.length,
        desc: descTransacao,
        value: parseFloat(valorTransacao),
        type: tipoTransacao == 1 ? "Despesa" : "Receita"
    }

    somaAoSaldo(transacao);
    somaReceitaDespesa(transacao);
    addTransacaoDOM(transacao);

    transacoesSalvas.push(transacao);
    localStorage.setItem(chave_transacoes_ls, JSON.stringify(transacoesSalvas));

    idSalvos.push(transacao.id);
    localStorage.setItem(chave_id_ls, JSON.stringify(idSalvos));

    descInput.value = '';
    tipoTransacaoComponente.value = '';
    valorInput.value = '';
    descInput.focus();
});

function saldoPositivo() {
    let valorBalanco = parseFloat(balancoH1.innerHTML.replace("R$", "").trim());
    if (valorBalanco < 0) {
        balancoH1.style.color = "#c0392b";
    } else {
        balancoH1.style.color = "#fff";
    }
}

function somaAoSaldo(transacao) {
    const isReceita = transacao.type == "Receita";
    let valorBalanco = parseFloat(balancoH1.innerHTML.replace("R$", "").trim()) || 0;
    valorBalanco = isReceita ? valorBalanco + transacao.value : valorBalanco - transacao.value;

    balancoH1.innerHTML = `R$${valorBalanco.toFixed(2)}`;
    saldoPositivo();
}

function atualizaSaldoRemovido(transacao) {
    const isReceita = transacao.type == "Receita";
    let valorBalanco = parseFloat(balancoH1.innerHTML.replace("R$", "").trim()) || 0;
    valorBalanco = isReceita ? valorBalanco - transacao.value : valorBalanco + transacao.value;

    balancoH1.innerHTML = `R$${valorBalanco.toFixed(2)}`;
    saldoPositivo();
}

function somaReceitaDespesa(transacao) {
    const isReceita = transacao.type == "Receita";
    const elemento = isReceita ? receita : despesa;
    const substituir = isReceita ? "+ R$" : "- R$";

    let valor = parseFloat(elemento.innerHTML.replace(substituir, "").trim()) || 0;
    valor += Math.abs(transacao.value);
    elemento.innerHTML = `${substituir}${valor.toFixed(2)}`;
}

function atualizaReceitaDespesaRemovida(transacao) {
    const isReceita = transacao.type == "Receita";
    const elemento = isReceita ? receita : despesa;
    const substituir = isReceita ? "+ R$" : "- R$";

    let valor = parseFloat(elemento.innerHTML.replace(substituir, "").trim()) || 0;
    valor -= Math.abs(transacao.value);
    elemento.innerHTML = `${substituir}${valor.toFixed(2)}`;
}

function addTransacaoDOM(transacao) {
    const isReceita = transacao.type == "Receita";
    const cssClass = isReceita ? 'positivo' : 'negativo';
    const currency = isReceita ? '+R$' : '-R$';
    const liElementStr = `${transacao.desc} <span>${currency}${Math.abs(transacao.value)}</span><button class="delete-btn" onclick="deletaTransacao(${transacao.id})">X</button>`;

    const liElement = document.createElement('li');
    liElement.innerHTML = liElementStr;
    liElement.classList.add(cssClass);
    liElement.setAttribute('data-id', transacao.id);
    transacaoUL.appendChild(liElement);
}

function carregaDados() {
    transacaoUL.innerHTML = '';
    balancoH1.innerHTML = 'R$0.00';
    receita.innerHTML = '+ R$0.00';
    despesa.innerHTML = '- R$0.00';

    for (let i = 0; i < transacoesSalvas.length; i++) {
        let transacao = transacoesSalvas[i];
        somaAoSaldo(transacao);
        somaReceitaDespesa(transacao);
        addTransacaoDOM(transacao);
    }
}

function deletaTransacao(id) {
    const transacaoIndex = transacoesSalvas.findIndex((transacao) => transacao.id == id);

    if (transacaoIndex !== -1) {
        atualizaSaldoRemovido(transacoesSalvas[transacaoIndex]);
        atualizaReceitaDespesaRemovida(transacoesSalvas[transacaoIndex]);

        transacoesSalvas.splice(transacaoIndex, 1);
        localStorage.setItem(chave_transacoes_ls, JSON.stringify(transacoesSalvas));

        const elementoRemovido = document.querySelector(`li[data-id="${id}"]`);
        if (elementoRemovido) {
            elementoRemovido.remove();
        }
    }

    carregaDados();
}

carregaDados();