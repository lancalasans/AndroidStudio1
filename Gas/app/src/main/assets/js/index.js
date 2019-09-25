var qNumb = 0;
var question = '<h1>Olá, Qual posto você abasteceu?</h1>';
var output = document.getElementById('output');
output.innerHTML = question;


var posto="";
var litros="";
var quilometragem="";
var preco="";
var atendimento="";

function chatBot() {
  var input = document.getElementById('input').value;
  console.log(input);
  
  if (qNumb == 0) {
    posto = input;
    output.innerHTML = '<h1>Entendi! Você abasteceu no posto, ' + posto + '.</h1>';
    document.getElementById('input').value = "";
    question = '<h1>Quantos Litros você abasteceu?</h1>';
    setTimeout(timedQuestion, 3000);
  }
  
  else if (qNumb == 1) {
    litros = input;
    output.innerHTML = '<h1>Entendi. Você abasteceu '+ litros + ' litros.</h1>';
    document.getElementById('input').value = "";
    question = '<h1>Qual a quilometragem atual?</h1>';
    setTimeout(timedQuestion, 3000);
  }
  
  else if (qNumb == 2) {
    quilometragem = input;
    output.innerHTML = '<h1>Ok! A quilometragem está em '+ quilometragem + '.</h1>';
    document.getElementById('input').value = "";
    question = '<h1>Qual o preco do litro?</h1>';
    setTimeout(timedQuestion, 3000);
  }
  
  else if (qNumb == 3) {
    preco = input;
    output.innerHTML = '<h1>Entendi! O preço é de ' + preco + ' reais.</h1>';
    document.getElementById('input').value = "";
    question = '<h1>Como você foi atendido?</h1>';
    setTimeout(timedQuestion, 3000);
  }
  
  else if (qNumb == 4) {
    atendimento = input;
    output.innerHTML = '<h1>Entendi! Você foi ' + atendimento + ' atendido.</h1>';
    document.getElementById('input').value = "";
    question = '<h1>Algum comentário?</h1>';
    setTimeout(timedQuestion, 3000);
  }
  
  else if (qNumb == 5) {
    output.innerHTML = '<h1>Ok. Entendi!</h1>';
    document.getElementById('input').value = "";
    question = '<h1>Posso Gravar as informações?</h1>';
    setTimeout(timedQuestion, 3000);
  }
  else if (qNumb == 6) {
    switch(input) {
      case "sim":
      output.innerHTML = '<h1>Enviando ao Banco de Dados!</h1>';
      Marcus.grava(posto, litros, quilometragem, preco, atendimento);
      break;
      case "s":
            output.innerHTML = '<h1>Enviando ao Banco de Dados!</h1>';
            break;
      case "não":
      output.innerHTML = '<h1>Ok, informações descartadas</h1>';
    }
    document.getElementById('input').value = "";
    question = '<h1>Olá, Qual posto você abasteceu?</h1>';
    setTimeout(timedQuestion, 3000);
  }
  
}

function timedQuestion() {
  output.innerHTML = question;
}

// $(document).keypress(function(e) {
//  if (e.which == 13) {
//   chatBot();
//   qNumb++
// }                   
// });

document.getElementById('input').addEventListener('keypress', pressKey);

function pressKey(event) {
  if (event.which == 13) {
    chatBot();
    qNumb++
  }
  if (qNumb>6) qNumb=0;
}