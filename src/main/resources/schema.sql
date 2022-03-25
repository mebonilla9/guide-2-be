create or replace function log_insert_audit_students()
    returns trigger
    language plpgsql
as
$$
begin
    insert into audit_student(id,
                              db_user,
                              modify,
                              new_name,
                              new_program,
                              previous_name,
                              previous_program,
                              process,
                              id_student)
    values (nextval('audit_student_id_sequence'),
            (select current_user),
            now(),
            new.name,
            new.program,
            old.name,
            old.program,
            'insertar',
            new.id);
    return new;
end;
$$;

-- drop trigger insert_audit_students on public.student;

create trigger insert_audit_students
    after insert or update
    on public.student
    for each row
    execute procedure log_insert_audit_students();