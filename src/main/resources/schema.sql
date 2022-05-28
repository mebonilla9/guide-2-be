create or replace function log_insert_audit_students()
    returns trigger
    language plpgsql
as
$$
begin
    insert into audit_student(id,
                              db_user,
                              modify,
                              new_first_name,
                              new_last_name,
                              new_program,
                              previous_first_name,
                              previous_last_name,
                              previous_program,
                              process,
                              id_student)
    values (nextval('audit_student_id_sequence'),
            (select current_user),
            now(),
            new.first_name,
            new.last_name,
            new.program,
            old.first_name,
            old.last_name,
            old.program,
            tg_op,
            new.id);
    return new;
end;
$$;

-- drop trigger insert_audit_students on public.student;

create trigger insert_audit_students
    after insert or update or delete
    on public.student
    for each row
    execute procedure log_insert_audit_students();