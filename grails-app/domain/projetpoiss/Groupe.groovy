package projetpoiss

class Groupe {
    String nom
    String description
    Image image

    static hasMany = [pois : Poi]
    static constraints = {
        nom nullable: false , unique: true
        description nullable: true
        image nullable: true


    }
}

