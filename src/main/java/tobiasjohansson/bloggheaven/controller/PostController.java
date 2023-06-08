package tobiasjohansson.bloggheaven.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    /**
     *
     * GET /api/posts - Hämtar alla blogginlägg från databasen.
     * GET /api/posts/{id} - Hämtar ett specifikt blogginlägg baserat på ID.
     * POST /api/newpost - Skapar ett nytt blogginlägg.
     * PUT /api/updatepost/{id} - Uppdaterar ett befintligt blogginlägg baserat på ID.
     * DELETE /api/deletepost/{id} - Tar bort ett befintligt blogginlägg baserat på ID.
     */
}
