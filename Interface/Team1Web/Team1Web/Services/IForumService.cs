using Team1Web.Models;

namespace Team1Web.Services
{
    public interface IForumService
    {
        Task<List<Forum>> GetForums();
    }
}
