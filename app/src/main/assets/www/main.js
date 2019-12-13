
var btn = document.getElementById("btnjavascript");

btn.addEventListener("click", function(){
    android.enviaParaNativo(getTextWebView())
   document.getElementById('busca').value = ''
});

function getTextWebView() {
    var text = document.getElementById("busca").value;
    return text;
}

function enviaParaWebView(message){
        document.getElementById("busca").value = message;
        android.limpar(message)
}
