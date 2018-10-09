using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CORE
{
    public interface IConfig { string ConnectionString(); }

    public class Config:IConfig
    {
        private readonly IConfiguration Configuration;

        public Config(IConfiguration configuration)
        {
            Configuration = configuration;
        }
       
        public string ConnectionString()
        {
            return Configuration["postgresql:port"];
        }

    }
}
