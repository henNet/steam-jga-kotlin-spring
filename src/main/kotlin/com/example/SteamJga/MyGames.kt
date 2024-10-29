package com.example.SteamJga

/* Classe que representa um Jogo */
data class Game(val id: Int, val name: String, val cover: String)

/* Classe Genérica para tratativa de respostas */
class Response<T>(val data: T)

/* Classe que representa um banco de dados em formato Lista para guardar
 * instancias de jogos em tempo de execução */
class MyGames {
  /* Banco de dados dos jogos representado por uma lista */
  val allMyGames: MutableList<Game>;

  constructor(){
    allMyGames = mutableListOf(
      Game(1, "Sombras da Guerra", "https://m.media-amazon.com/images/I/91gPp8gUvWL._AC_UF1000,1000_QL80_.jpg"),
      Game(2, "Tomb Raider", "https://m.media-amazon.com/images/I/81XmzKjxu4L._AC_UF350,350_QL50_.jpg"),
      Game(3, "Dark Souls", "https://m.media-amazon.com/images/I/71xY1CYZmfL._AC_UF1000,1000_QL80_.jpg"),
      Game(4, "Dark Chemestry", "https://i.ibb.co/1RqD5q5/dark.png"),
      Game(5, "Red Dead Redemption 2", "https://m.media-amazon.com/images/I/71XrxGqPosL._AC_UF1000,1000_QL80_.jpg"),
      Game(6, "Marvel's Spider-Man: Miles Morales", "https://m.media-amazon.com/images/I/71K4AqkJibL.jpg"),
      Game(7, "Star Wars Jedi: Fallen Order", "https://m.media-amazon.com/images/I/61PAS17sL3L._AC_UF1000,1000_QL80_.jpg")
    )
  }

  fun getAllMyGame(): List<Game> {
    return allMyGames;
  }

  fun getMyGameById(id: Any): Response<out Any>{
    var gameAux = Game(0, "", "");

    for(game in allMyGames){
      if(game.id.toString() == id.toString()){
        gameAux = game;
        break;
      }
    }

    if(gameAux.id != 0){
      val response = Response<Game>(gameAux);
      return response;
    }else{
      val response = Response<String>("Game Not Found");
      return response;
    }
  }

  fun insertMyGame(game: Game) :Response<out Any> {
    allMyGames.add(game);
    return Response<String>("Game Insert Succesfully!")
  }

  fun deleteMyGameById(id: Any): Response<out Any>{
    var gameAux = Game(0, "", "");

    for(game in allMyGames){
      if(game.id.toString() == id.toString()){
        gameAux = game;
        break;
      }
    }
    val result = allMyGames.remove(gameAux)

    return if(result)
      Response<String>("Game delete Successfully");
    else
      Response<String>("Game delete failed");
  }
}

