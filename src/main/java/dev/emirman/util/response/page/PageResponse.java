package dev.emirman.util.response.page;

import dev.emirman.util.response.base.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.TreeMap;

import static org.springframework.http.HttpStatus.OK;

public record PageResponse<K>(Page<K> data, List<K> response) {
    public ResponseEntity<Response> of(String name, String message) {
        return Response.builder()
                .withMessage(message)
                .withStatus(OK)
                .withDetails(new TreeMap<>() {{
                    put("info", new TreeMap<>() {{
                        put("totalItems", data.getTotalElements());
                        put("pageSize", data.getSize());
                        put("pageCount", data.getTotalPages());
                        put("currentPage", data.getNumber());
                        put("hasNext", data.hasNext());
                        put("hasPrevious", data.hasPrevious());
                        put("currentPageSize", data.getNumberOfElements());
                        put("remainingPages", data.getTotalPages() - data.getNumber() - 1);
                    }});
                    put(name, response);
                }})
                .build();
    }
}
