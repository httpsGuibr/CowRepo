document.getElementById("interestForm").addEventListener("submit", function(event) {
    event.preventDefault();

    // Mostra o pop-up
    const popup = document.getElementById("popup");
    popup.style.display = "block";

    // Configura a barra de progresso
    const progressBar = document.getElementById("progressBar");
    let progress = 100;
    progressBar.style.width = progress + "%";

    // Atualiza a barra de progresso a cada 50 ms
    const interval = setInterval(() => {
        progress -= 2;
        progressBar.style.width = progress + "%";
        if (progress <= 0) {
            clearInterval(interval);
            popup.style.display = "none"; // Esconde o pop-up após 5 segundos
        }
    }, 100);

    // Aqui você pode adicionar lógica para processar o formulário, como enviar os dados por email ou para um backend
});