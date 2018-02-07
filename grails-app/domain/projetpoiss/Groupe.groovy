package projetpoiss

class Groupe {
    String nom
    String description
    Image image

    static hasMany = [pois : Poi]
    static constraints = {
        description nullable: true
        image nullable: true
        nom nullable: false , unique: true
    }
}

