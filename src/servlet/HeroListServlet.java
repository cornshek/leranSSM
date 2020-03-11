package servlet;

import dao.HeroDAO;
import bean.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HeroListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start = 0;
        int count = 5;
        try {
            start = Integer.parseInt(req.getParameter("start"));
        } catch (NumberFormatException e) {

        }
        //上一页next 下一页pre
        int next = start + count;
        int pre = start - count;

        //末页last
        //根据total计算last
        int last;
        int total = new HeroDAO().getTotal();
        //如果total能够被count整除，last=total-count
        //否则，last=total-total%count
        if (0 == total % count) {
            last = total - count;
        } else {
            last = total - total % count;
        }

        //pre、next的边界处理
        pre = Math.max(pre, 0);
        next = Math.min(next, last);

        //将next、pre、last通过requestContext传递到jsp页面
        req.setAttribute("next", next);
        req.setAttribute("pre", pre);
        req.setAttribute("last", last);

        //根据计算好的start分页查询heroes，通过requestContext传递到jsp页面
        List<Hero> heroes = new HeroDAO().list(start, count);
        req.setAttribute("heroes", heroes);

        //重定向至listHero.jsp
        req.getRequestDispatcher("listHero.jsp").forward(req, resp);
    }
}
