﻿using System.Collections.Generic;

namespace CarsMatter.Infrastructure.Models.MsSQL
{
    public class KindOfService
    {
        public string Id { get; set; }

        public string Name { get; set; }

        public ICollection<ConsumablesNote> ConsumablesNotes { get; set; }

        public KindOfService()
        {
            this.ConsumablesNotes = new List<ConsumablesNote>();
        }
    }
}
