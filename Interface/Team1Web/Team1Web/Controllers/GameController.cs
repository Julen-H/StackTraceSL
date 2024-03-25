using Team1Web.Models;
using Newtonsoft.Json;
using System.Net.Http.Headers;

using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.Extensions.DependencyInjection;
using Team1Web.Services;

namespace Team1Web.Controllers
{
    //[Authorize]
    public class GameController : Controller
    {
        private readonly IGameService _gameService;
        public GameController(IGameService gameService)
        {
            _gameService = gameService;
        }
        public async Task<ActionResult> Ranking()
        {
            List<GameData> gameList = new List<GameData>();
            gameList = await _gameService.GetGameData();
            return View(gameList);
        }
        public async Task<ActionResult> Best_Players()
        {
            List<GameData> gameList = new List<GameData>();
            gameList = await _gameService.GetGameData();
            return View(gameList);
        }
        public async Task<ActionResult> BestTeams()
        {
            List<GameData> gameList = await _gameService.GetGameData();

            List<Team> bestTeams = new List<Team>();

            for (int i = 0; i < 4; i++)
            {
                var topGames = gameList.Where(g => g.jokoa == i + 1).OrderByDescending(g => g.puntuazioa).Take(5).ToList();

                for (int j = 0; j < topGames.Count; j++)
                {
                    var game = topGames[j];
                    int points = 10 - j;

                    Team team = new Team
                    {
                        partidaId = game.partidaId,
                        izena = game.izena,
                        idEnpresa = game.idEnpresa,
                        jaiotzeData = game.jaiotzeData,
                        puntuazioa = game.puntuazioa,
                        lanpostua = game.lanpostua,
                        jokoa = game.jokoa,
                        partidaData = game.partidaData,
                        talde_puntuazioa = points 
                    };

                    bestTeams.Add(team);
                }
            }

            var companyScores = bestTeams.GroupBy(t => t.idEnpresa)
                                          .Select(group => new Team { idEnpresa = group.Key, talde_puntuazioa = group.Sum(t => t.talde_puntuazioa) })
                                          .OrderByDescending(group => group.talde_puntuazioa)
                                          .ToList();

            return View(companyScores);
        }




    }
}

