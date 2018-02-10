package projetpoiss

class Image {
    String fileName
    byte[] associatedFile
    String contentType


    static constraints = {


        fileName unique: true

    }
}