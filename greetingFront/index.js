// Fonction pour récupérer le message
async function loadGreeting() {
    const messageElement = document.querySelector(".message p");

    try {
        const response = await fetch('http://localhost:8080/api/greets/get/default');

        if (!response.ok) throw new Error("Erreur réseau");

        const data = await response.json();

        // On remplace le texte du paragraphe par le message reçu
        messageElement.textContent = data.message;
    } catch (error) {
        console.error("Erreur:", error);
        messageElement.textContent = "Impossible de charger le message.";
    }
}

// Exécution au chargement du DOM
document.addEventListener("DOMContentLoaded", loadGreeting);
