using System.ComponentModel.DataAnnotations;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Team1Web.Models
{
    public class Team
    {
        public int partidaId { get; set; }
        public String izena { get; set; }
        public int idEnpresa { get; set; }
        public String jaiotzeData { get; set; }
        public int puntuazioa { get; set; }
        public String lanpostua { get; set; }
        public int jokoa { get; set; }
        public String partidaData { get; set; }
        public int talde_puntuazioa { get; set; }
    }
}
