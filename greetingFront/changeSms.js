import { API_BASE_URL } from "./config.js";

const messageElement = document.querySelector(".message p");
const textarea = document.querySelector("#put");
const form = document.querySelector(".manageSms");

// 1. Charger le dernier message
async function loadLastGreeting() {
    try {
        const response = await fetch(`${API_BASE_URL}/api/greets/get/last`);
        if (!response.ok) throw new Error("Non trouvé");
        const data = await response.json();
        messageElement.textContent = data.message;
    } catch (error) {
        console.error("Erreur:", error);
        messageElement.textContent = "Aucun message trouvé.";
    }
}

// 2. Changer le message
form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const newMessage = textarea.value;

    try {
        // Comme tu utilises @RequestParam, on ajoute le texte dans l'URL
        const url = `${API_BASE_URL}/api/greets/change?message=${encodeURIComponent(newMessage)}`;

        const response = await fetch(url, {
            method: "PUT"
        });

        if (response.ok) {
            textarea.value = ""; // Vide le champ
            loadLastGreeting();  // Rafraîchit l'affichage
        } else {
            alert("Erreur lors de la mise à jour");
        }
    } catch (error) {
        console.error("Erreur:", error);
    }
});

// 3. Bouton Reset
document.querySelector(".reset").addEventListener("click", () => {
    textarea.value = "";
});

// Lancement au démarrage
document.addEventListener("DOMContentLoaded", loadLastGreeting);