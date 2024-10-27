package ru.clevertec.check.servlet;

import com.google.gson.Gson;
import ru.clevertec.check.dto.DiscountCardDto;
import ru.clevertec.check.exception.BadRequestException;
import ru.clevertec.check.exception.InternalServerException;
import ru.clevertec.check.exception.NotEnoughMoneyException;
import ru.clevertec.check.exception.NotFoundException;
import ru.clevertec.check.repository.DB.DiscountCardRepositoryImpl;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.impl.DiscountCardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.http.HttpServletResponse.SC_OK;

@WebServlet("/discountcards")
public class DiscountCardServlet extends HttpServlet {
    private DiscountCardService discountCardService;

    @Override
    public void init() {
        this.discountCardService = new DiscountCardServiceImpl(new DiscountCardRepositoryImpl());
    }

    //   http://localhost:8080/discountcards?id=1
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        DiscountCardDto discountCardDto = null;
        try {
            discountCardDto = discountCardService.getById(id);
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
        String json = new Gson().toJson(discountCardDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(SC_OK);
        }
    }

    //http://localhost:8080/discountcards
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        DiscountCardDto discountCardDto = new Gson().fromJson(req.getReader(), DiscountCardDto.class);
        DiscountCardDto newDiscountCardDto = null;
        try {
            newDiscountCardDto = discountCardService.create(discountCardDto);
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
        String json = new Gson().toJson(newDiscountCardDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(SC_OK);
        }
    }

    //    http://localhost:8080/discountcards?id=1
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DiscountCardDto discountCardDto = new Gson().fromJson(req.getReader(), DiscountCardDto.class);
        discountCardDto.setId(Integer.parseInt(req.getParameter("id")));
        try {
            if (discountCardService.update(discountCardDto)) {
                resp.setStatus(SC_OK);
            } else throw new BadRequestException();
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
    }

    //   http://localhost:8080/discountcards?id=1
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            if (discountCardService.delete(id)) {
                resp.setStatus(SC_OK);
            } else throw new BadRequestException();
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
    }
}