package projetpoiss

class Poi {
    String nom
    String desccription
    double latitude
    double longitude
    static hasMany = [images: Image , groupes : Groupe]

    static  belongsTo = [ groupes : Groupe]
    static constraints = {
        desccription nullable: true
        nom nullable: false , unique: true
        latitude blank : true
        longitude blank : true

    }
}
