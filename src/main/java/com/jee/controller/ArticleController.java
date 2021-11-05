package com.jee.controller;


import com.jee.model.ArticleDo;
import com.jee.service.imp.ArticleDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ArticleController {

	private ArticleDaoImpl articleDao;

	@Autowired
    public ArticleController(ArticleDaoImpl articleDao) {
        this.articleDao = articleDao;
    }

	// crud article  controller
	@RequestMapping(value="/articles", method= RequestMethod.GET)
    public String listArticles(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        System.out.println("hello");
        return "articles";
    }

	@RequestMapping(value="/articles/{id}", method=RequestMethod.DELETE)
    public String deleteArticle(@PathVariable("id") int id) {
        articleDao.delete(id);
        return "redirect:/articles";
    }

	@RequestMapping(value="/articles/{id}", method=RequestMethod.PUT)
    public String updateArticle(@PathVariable("id") int id, @RequestBody ArticleDo article) {
        articleDao.update(article);
        return "redirect:/articles";
    }

	@RequestMapping(value="/articles", method=RequestMethod.POST)
    public String createArticle(@RequestBody ArticleDo article) {
        articleDao.create(article);
        return "redirect:/articles";
    }

}
