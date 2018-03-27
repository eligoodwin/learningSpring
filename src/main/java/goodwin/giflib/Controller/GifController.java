package goodwin.giflib.Controller;

import goodwin.giflib.Data.GifRepo;
import goodwin.giflib.models.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepo gifRepo;

    @RequestMapping(value = "/")
    public String listGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepo.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping(value = "/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepo.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }
}
