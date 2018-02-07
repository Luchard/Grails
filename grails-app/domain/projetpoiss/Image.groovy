package projetpoiss

class Image {
    String filename

    Poi poi

    static constraints = {

        poi nullable: true
        filename unique: true
    }
}