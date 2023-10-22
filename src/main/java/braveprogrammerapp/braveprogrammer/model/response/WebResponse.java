package braveprogrammerapp.braveprogrammer.model.response;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {

    private T data;

    private String errors;
}