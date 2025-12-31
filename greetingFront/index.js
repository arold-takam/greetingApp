// Fonction pour récupérer le message
import {API_BASE_URL} from "./config.js";

async function loadGreeting() {
    const messageElement = document.querySelector(".message p");

    try {
        const response = await fetch(`${API_BASE_URL}/api/greets/get/default`);

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
