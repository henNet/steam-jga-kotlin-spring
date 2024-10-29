package com.example.SteamJga

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class SteamJgaController {

  val myGames = MyGames();

  @GetMapping("/all")
  fun getAllGames(): List<Game>{
    return myGames.getAllMyGame();
  }

  @GetMapping("/search")
  fun getGameById(@RequestParam("id") id: Any) : Response<out Any>{
    return myGames.getMyGameById(id);
  }

  @GetMapping("/insert")
  fun insertGame(@RequestParam("id") id: Any = 0,
                 @RequestParam("name") name: String = "",
                  @RequestParam("cover") cover: String = "")
  : Response<out Any> {

    println("$id $name $cover");

    if(id.toString().toIntOrNull() != null) {
      val gameAux = Game(id.toString().toInt(), name, cover);
      return myGames.insertMyGame(gameAux);
    }else{
      return Response<String>("Invalid Game id");
    }
  }

  @GetMapping("/delete")
  fun deleteGameById(@RequestParam("id") id: Any): Response<out Any>{
    return myGames.deleteMyGameById(id);
  }
}






