package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.MHorarioNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.MHorarioMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MHorarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MHorarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.MHorario;
import com.academy.edusmart.EduSmartAcademyAPI.repository.MHorarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MHorarioServiceImp implements MHorarioService{
    private final MHorarioRepository mHorarioRepository;

    public MHorarioServiceImp(MHorarioRepository mHorarioRepository){
        this.mHorarioRepository = mHorarioRepository;
    }

    @Override
    public List<MHorarioResponse> findAll() {
        List<MHorario> mHorarioList = mHorarioRepository.findAll();
        List<MHorarioResponse> mHorarioResponses= new ArrayList<>();

        for (MHorario mHorario : mHorarioList) {
            mHorarioResponses.add(MHorarioMapper.INSTANCE.toMHorarioResponse(mHorario));
        }

        return mHorarioResponses;
    }

    @Override
    public MHorarioResponse findById(Long id) {
        Optional<MHorario> optionalMHorario = mHorarioRepository.findById(id);

        if(optionalMHorario.isEmpty()) throw new MHorarioNotFoundExcep();

        return MHorarioMapper.INSTANCE.toMHorarioResponse(optionalMHorario.get());
    }

    @Override
    public MHorarioResponse create(MHorarioRequest mHorarioRequest) {
        MHorario mHorario = new MHorario();
        mHorario.setDia(mHorarioRequest.getDia());
        mHorario.setGestion(mHorarioRequest.getGestion());
        MHorario mHorarioSaved = mHorarioRepository.save(mHorario);

        return MHorarioMapper.INSTANCE.toMHorarioResponse(mHorarioSaved);
    }

    @Override
    public MHorarioResponse update(Long id, MHorarioRequest mHorarioRequest) {
        Optional<MHorario> optionalMHorario = mHorarioRepository.findById(id);

        if(optionalMHorario.isEmpty()) throw new MHorarioNotFoundExcep();

        MHorario mHorario = optionalMHorario.get();
        mHorario.setDia(mHorarioRequest.getDia());
        mHorario.setGestion(mHorarioRequest.getGestion());
        MHorario mHorarioSaved = mHorarioRepository.save(mHorario);

        return MHorarioMapper.INSTANCE.toMHorarioResponse(mHorarioSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<MHorario> optionalMHorario = mHorarioRepository.findById(id);

        if(optionalMHorario.isEmpty()) throw new MHorarioNotFoundExcep();

        mHorarioRepository.delete(optionalMHorario.get());
    }
}
