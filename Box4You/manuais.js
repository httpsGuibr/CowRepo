document.addEventListener("DOMContentLoaded", function() {
    const seletorModelo = document.getElementById("modelo-select");
    const gerarPdfButton = document.getElementById("gerar-pdf");

    // Habilitar o botão "Gerar Manual" quando o modelo for selecionado
    seletorModelo.addEventListener("change", function() {
        if (seletorModelo.value) {
            gerarPdfButton.disabled = false;
        } else {
            gerarPdfButton.disabled = true;
        }
    });

    // Função para gerar o PDF
    gerarPdfButton.addEventListener("click", function() {
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF();

        // Texto do manual fictício
        const manualTexto = `
        Manual do Modelo: ${seletorModelo.value === "nikola" ? "Box4you Nikola" : "Box4you Albert"}

        Este é um manual simples para o modelo escolhido. 
        Aqui você encontrará informações úteis:

        1. Descrição do produto.
        2. Como usar a máquina.
        3. Manutenção básica.
        4. Contatos para suporte.

        Obrigado por escolher Box4you!`;

        // Adicionando o texto no PDF
        doc.text(manualTexto, 10, 10);

        // Gerar o PDF e abrir em uma nova aba
        doc.save(`manual_${seletorModelo.value}.pdf`);
    });
});
