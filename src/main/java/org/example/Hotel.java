package org.example;

import java.util.List;

public class Hotel {

    public class Hotel {
        private int id;
        private String nomHotel;
        private String emailHotel;
        private String telephone;
        private String adresse;
        private List<com.mairsa.Chambre> listChambres;

        public Hotel(int id, String nomHotel, String emailHotel, String telephone, String adresse, List<com.mairsa.Chambre> listChambres) {
            this.id = id;
            this.nomHotel = nomHotel;
            this.emailHotel = emailHotel;
            this.telephone = telephone;
            this.adresse = adresse;
            this.listChambres = listChambres;
        }

        public int getId() {return id;}
        public void setId(int id) {this.id = id;}

        public String getNomHotel() {return nomHotel;}
        public void setNomHotel(String nomHotel) {this.nomHotel = nomHotel;}

        public String getEmailHotel() {return emailHotel;}
        public void setEmailHotel(String emailHotel) {this.emailHotel = emailHotel;}

        public String getTelephone() {return telephone;}
        public void setTelephone(String telephone) {this.telephone = telephone;}

        public String getAdresse() {return adresse;}
        public void setAdresse(String adresse) {this.adresse = adresse;}

        public List<Chambre> getListChambres() {return listChambres;}
        public void setListChambres(List<Chambre> listChambres) {this.listChambres = listChambres;}

        public void ajouterChambre(Chambre chambre) {
            if (chambre != null) {
                this.listChambres.add(chambre);
                System.out.println("La chambre a été ajoutée avec succès.");
            } else {
                System.out.println("Erreur : la chambre ne peut pas être nulle.");
            }
        }

        public void afficherChambresLibresAvecLeurType() {
            System.out.println("--- Liste des chambres libres ---");
            boolean aucuneChambreLibre = true;
            for (Chambre chambre : listChambres) {
                // On suppose que Chambre possède la méthode isLibre()
                if (chambre.estLibre()) {
                    // On affiche le numéro (ou un identifiant) et le type de la chambre
                    System.out.println("Chambre N°" + chambre.getNumero() + " | Type : " + chambre.getType());
                    aucuneChambreLibre = false;
                }
            }
            if (aucuneChambreLibre) {
                System.out.println("Actuellement, il n'y a aucune chambre libre dans l'hôtel.");
            }
        }

        // 3. Méthode pour trouver la chambre occupée par un client spécifique (via son ID)
        public Chambre trouverChambreOccupeeParClient(int idClient) {
            for (Chambre chambre : listChambres) {
                // On vérifie d'abord que la chambre n'est pas libre, puis on vérifie l'ID du client
                // On suppose que Chambre possède la méthode getClient()
                if (!chambre.estLibre() && chambre.getClient() != null) {
                    if (chambre.getClient().getId() == idClient) {
                        return chambre; // Retourne l'objet Chambre si le client est trouvé
                    }
                }
            }
            return null; // Retourne null si le client ne loge dans aucune chambre
        }
        public List<Chambre> getListChambres() {
            return listChambres;
        }
    }

}
