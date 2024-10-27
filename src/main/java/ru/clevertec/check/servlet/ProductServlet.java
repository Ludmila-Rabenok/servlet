package ru.clevertec.check.servlet;

import com.google.gson.Gson;
import ru.clevertec.check.dto.ProductDto;
import ru.clevertec.check.exception.BadRequestException;
import ru.clevertec.check.exception.InternalServerException;
import ru.clevertec.check.exception.NotEnoughMoneyException;
import ru.clevertec.check.exception.NotFoundException;
import ru.clevertec.check.repository.DB.ProductRepositoryImpl;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.http.HttpServletResponse.SC_OK;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() {
        this.productService = new ProductServiceImpl(new ProductRepositoryImpl());
    }

    //   http://localhost:8080/products?id=1
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDto productDto = null;
        try {
            productDto = productService.getById(id);
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
        String json = new Gson().toJson(productDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(SC_OK);
        }
    }

    //http://localhost:8080/products
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        ProductDto productDto = new Gson().fromJson(req.getReader(), ProductDto.class);
        ProductDto newProductDto = null;
        try {
            newProductDto = productService.create(productDto);
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
        String json = new Gson().toJson(newProductDto);
        try (PrintWriter out = resp.getWriter()) {
            out.write(json);
            resp.setStatus(SC_OK);
        }
    }

    //http://localhost:8080/products?id=1
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductDto productDto = new Gson().fromJson(req.getReader(), ProductDto.class);
        productDto.setId(Integer.parseInt(req.getParameter("id")));
        try {
            if (productService.update(productDto)) {
                resp.setStatus(SC_OK);
            } else throw new BadRequestException();
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
    }

    //   http://localhost:8080/products?id=1
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            if (productService.delete(id)) {
                resp.setStatus(SC_OK);
            } else throw new BadRequestException();
        } catch (BadRequestException | NotEnoughMoneyException | InternalServerException | NotFoundException e) {
            resp.setStatus(Integer.parseInt(e.getMessage()));
        }
    }
}
