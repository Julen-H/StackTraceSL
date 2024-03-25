using System.ComponentModel.DataAnnotations;

namespace Team1Web.Models
{
    public class Forum
    {
        [Key]
        public int Id { get; set; }
        public string Galdera1 { get; set; }
        public string Galdera2 { get; set; }
        public int Rating { get; set; }
      
    }
}

