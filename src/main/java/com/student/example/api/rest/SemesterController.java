package com.student.example.api.rest;

import com.student.example.domain.Semester;
import com.student.example.exception.DataFormatException;
import com.student.example.service.SemesterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/example/v1/student/semester")
@Api(tags = {"semester"})
public class SemesterController extends AbstractRestHandler {

    @Autowired
    private SemesterService semesterService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a semester resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createStudent(@RequestBody Semester semester,
                              HttpServletRequest request, HttpServletResponse response) {
        Semester createdSemeter = this.semesterService.createSemester(semester);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdSemeter.getId()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all semesters.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Semester> getAllSemester(@ApiParam(value = "The page number (zero-based)", required = true)
                                @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                @ApiParam(value = "Tha page size", required = true)
                                @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                HttpServletRequest request, HttpServletResponse response) {
        return this.semesterService.getAllSemesters(page, size);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single semester.", notes = "You have to provide a valid semester ID.")
    public
    @ResponseBody
    Semester getSemester(@ApiParam(value = "The ID of the student.", required = true)
                       @PathVariable("id") Long id,
                       HttpServletRequest request, HttpServletResponse response) throws Exception {
        Semester semester = this.semesterService.getSemester(id);
        checkResourceFound(semester);
        return semester;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a semester resource.", notes = "You have to provide a valid semester ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateStudent(@ApiParam(value = "The ID of the existing semester resource.", required = true)
                              @PathVariable("id") Long id, @RequestBody Semester semester,
                              HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.semesterService.getSemester(id));
        if (id != semester.getId()) throw new DataFormatException("ID doesn't match!");
        this.semesterService.updateSemester(semester);
    }

    //todo: @ApiImplicitParams, @ApiResponses
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a semester resource.", notes = "You have to provide a valid student ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteStudent(@ApiParam(value = "The ID of the existing semester resource.", required = true)
                              @PathVariable("id") Long id, HttpServletRequest request,
                              HttpServletResponse response) {
        checkResourceFound(this.semesterService.getSemester(id));
        this.semesterService.deleteSemester(id);
    }
}