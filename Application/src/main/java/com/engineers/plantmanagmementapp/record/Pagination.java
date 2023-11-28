package com.engineers.plantmanagmementapp.record;

public record Pagination(Integer page, Integer size, String sortDirection, String sortColumn) {
}
