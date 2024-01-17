// script.js

// Fonction asynchrone pour récupérer et afficher les clients
async function logClients() {
    try {
        // Effectuer une requête Fetch vers l'URL des clients
        const response = await fetch("https://localhost/api/clients");

        // Vérifier si la requête a réussi (statut HTTP 200)
        if (!response.ok) {
            throw new Error(`Erreur HTTP! Statut: ${response.status}`);
        }

        // Convertir la réponse en format JSON
        const clients = await response.json();

        // Afficher les clients dans la console
        console.log(clients);
    } catch (error) {
        // Gérer les erreurs de manière appropriée
        console.error("Erreur lors de la récupération des clients:", error);
    }
}

// Appeler la fonction pour récupérer et afficher les clients
logClients();