using Team1Web.Models;
namespace Team1Web.Services
{
    public interface IGameService
    {
        Task<List<GameData>> GetGameData();
    }
}
