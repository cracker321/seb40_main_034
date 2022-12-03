import axios from 'axios';
import instance from './root';
import tokenInstance from './tokenroot';
export const postArticle = async (data) => {
  const url = '/main/submit';
  try {
    const result = await tokenInstance.post(url, data);
    return result.data;
  } catch (err) {
    return [err];
  }
};

export const locationSearch = async (data) => {
  const config = {
    headers: {
      'Content-Type': 'application/json; charset=UTF-8',
      Authorization: `KakaoAK ${process.env.REACT_APP_KAKAO_RESTAPI_KEY}`,
    },
  };
  const url = `https://dapi.kakao.com/v2/local/search/keyword.json?query=${data}`;
  try {
    const result = await axios.get(url, config);
    return result.data;
  } catch (err) {
    return err;
  }
};
