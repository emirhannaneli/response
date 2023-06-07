package dev.emirman.util.response.page;

import dev.emirman.util.response.base.Response;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.TreeMap;

public record PageResponse<K, V>(Page<K> data, List<V> response) {
    public Response of(String name, String message) {
        return Response.builder()
                .withMessage(message)
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
